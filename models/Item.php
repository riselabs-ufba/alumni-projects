<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "item".
 *
 * @property integer $id
 * @property integer $amount
 * @property string $price
 * @property string $opportunity_id
 * @property string $product_id
 *
 * @property Opportunity $opportunity
 * @property Product $product
 */
class Item extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'item';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['amount', 'opportunity_id', 'product_id'], 'integer'],
            [['price'], 'number'],
            [['opportunity_id', 'product_id'], 'required'],
            [['opportunity_id'], 'exist', 'skipOnError' => true, 'targetClass' => Opportunity::className(), 'targetAttribute' => ['opportunity_id' => 'id']],
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
            'amount' => 'Amount',
            'price' => 'Price',
            'opportunity_id' => 'Opportunity ID',
            'product_id' => 'Product ID',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getOpportunity()
    {
        return $this->hasOne(Opportunity::className(), ['id' => 'opportunity_id']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getProduct()
    {
        return $this->hasOne(Product::className(), ['id' => 'product_id']);
    }
}
