<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "poc".
 *
 * @property string $id
 * @property integer $previous_duration
 * @property integer $real_duration
 * @property string $person_name
 * @property string $fk_oportunity
 * @property string $final_status
 * @property string $product_id
 *
 * @property Opportunity $fkOportunity
 * @property Product $product
 */
class Poc extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'poc';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['previous_duration', 'real_duration', 'fk_oportunity', 'product_id'], 'integer'],
            [['fk_oportunity', 'final_status', 'product_id'], 'required'],
            [['person_name', 'final_status'], 'string', 'max' => 45],
            [['fk_oportunity'], 'exist', 'skipOnError' => true, 'targetClass' => Opportunity::className(), 'targetAttribute' => ['fk_oportunity' => 'id']],
            [['product_id'], 'exist', 'skipOnError' => true, 'targetClass' => Product::className(), 'targetAttribute' => ['product_id' => 'id']],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'id' => 'ID',
            'previous_duration' => 'Previous Duration',
            'real_duration' => 'Real Duration',
            'person_name' => 'Person Name',
            'fk_oportunity' => 'Fk Oportunity',
            'final_status' => 'Final Status',
            'product_id' => 'Product ID',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getFkOportunity()
    {
        return $this->hasOne(Opportunity::className(), ['id' => 'fk_oportunity']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getProduct()
    {
        return $this->hasOne(Product::className(), ['id' => 'product_id']);
    }
}
