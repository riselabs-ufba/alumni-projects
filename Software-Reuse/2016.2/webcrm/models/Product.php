<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "product".
 *
 * @property string $id
 * @property string $description
 *
 * @property Item[] $items
 * @property Poc[] $pocs
 */
class Product extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'product';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['description'], 'string', 'max' => 255],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'id' => 'ID',
            'description' => 'Description',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getItems()
    {
        return $this->hasMany(Item::className(), ['product_id' => 'id']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getPocs()
    {
        return $this->hasMany(Poc::className(), ['product_id' => 'id']);
    }
}
