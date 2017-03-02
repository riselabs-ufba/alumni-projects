<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "finder".
 *
 * @property string $id
 * @property string $name
 * @property string $phone
 * @property string $email
 * @property string $partner_id
 *
 * @property Partner $partner
 */
class Finder extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'finder';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['partner_id'], 'required'],
            [['partner_id'], 'integer'],
            [['name', 'phone', 'email'], 'string', 'max' => 45],
            [['partner_id'], 'exist', 'skipOnError' => true, 'targetClass' => Partner::className(), 'targetAttribute' => ['partner_id' => 'id']],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'id' => 'ID',
            'name' => 'Name',
            'phone' => 'Phone',
            'email' => 'Email',
            'partner_id' => 'Partner ID',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getPartner()
    {
        return $this->hasOne(Partner::className(), ['id' => 'partner_id']);
    }
}
