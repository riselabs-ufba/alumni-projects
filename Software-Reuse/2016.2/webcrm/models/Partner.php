<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "partner".
 *
 * @property string $id
 * @property string $social_name
 * @property string $fancy_name
 * @property string $cnpj
 * @property string $phone
 * @property string $create_date
 *
 * @property Finder[] $finders
 */
class Partner extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'partner';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['create_date'], 'safe'],
            [['social_name', 'fancy_name'], 'string', 'max' => 255],
            [['cnpj', 'phone'], 'string', 'max' => 45],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'id' => 'ID',
            'social_name' => 'Social Name',
            'fancy_name' => 'Fancy Name',
            'cnpj' => 'Cnpj',
            'phone' => 'Phone',
            'create_date' => 'Create Date',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getFinders()
    {
        return $this->hasMany(Finder::className(), ['partner_id' => 'id']);
    }
}
