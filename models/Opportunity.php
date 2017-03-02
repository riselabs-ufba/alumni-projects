<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "opportunity".
 *
 * @property string $id
 * @property string $company
 * @property string $person_name
 * @property string $person_email
 * @property string $person_tel
 * @property string $open_date
 * @property string $next_contact_date
 * @property string $note
 * @property string $user_id
 *
 * @property Acontecimento[] $acontecimentos
 * @property Item[] $items
 * @property Poc[] $pocs
 */
class Opportunity extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'opportunity';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['open_date', 'next_contact_date'], 'safe'],
            [['note'], 'string'],
            [['user_id'], 'required'],
            [['user_id'], 'integer'],
            [['company'], 'string', 'max' => 255],
            [['person_name', 'person_email', 'person_tel'], 'string', 'max' => 45],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'id' => 'ID',
            'company' => 'Company',
            'person_name' => 'Person Name',
            'person_email' => 'Person Email',
            'person_tel' => 'Person Tel',
            'open_date' => 'Open Date',
            'next_contact_date' => 'Next Contact Date',
            'note' => 'Note',
            'user_id' => 'User ID',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getAcontecimentos()
    {
        return $this->hasMany(Acontecimento::className(), ['oportunidade_id' => 'id']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getItems()
    {
        return $this->hasMany(Item::className(), ['opportunity_id' => 'id']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getPocs()
    {
        return $this->hasMany(Poc::className(), ['fk_oportunity' => 'id']);
    }
}
