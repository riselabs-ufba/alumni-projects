<?php

namespace app\models;

use Yii;
use yii\base\Model;
use yii\data\ActiveDataProvider;
use app\models\Opportunity;

/**
 * OpportunitySearch represents the model behind the search form about `app\models\Opportunity`.
 */
class OpportunitySearch extends Opportunity
{
    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['id', 'user_id'], 'integer'],
            [['company', 'person_name', 'person_email', 'person_tel', 'open_date', 'next_contact_date', 'note'], 'safe'],
        ];
    }

    /**
     * @inheritdoc
     */
    public function scenarios()
    {
        // bypass scenarios() implementation in the parent class
        return Model::scenarios();
    }

    /**
     * Creates data provider instance with search query applied
     *
     * @param array $params
     *
     * @return ActiveDataProvider
     */
    public function search($params)
    {
        $query = Opportunity::find();

        // add conditions that should always apply here

        $dataProvider = new ActiveDataProvider([
            'query' => $query,
        ]);

        $this->load($params);

        if (!$this->validate()) {
            // uncomment the following line if you do not want to return any records when validation fails
            // $query->where('0=1');
            return $dataProvider;
        }

        // grid filtering conditions
        $query->andFilterWhere([
            'id' => $this->id,
            'open_date' => $this->open_date,
            'next_contact_date' => $this->next_contact_date,
            'user_id' => $this->user_id,
        ]);

        $query->andFilterWhere(['like', 'company', $this->company])
            ->andFilterWhere(['like', 'person_name', $this->person_name])
            ->andFilterWhere(['like', 'person_email', $this->person_email])
            ->andFilterWhere(['like', 'person_tel', $this->person_tel])
            ->andFilterWhere(['like', 'note', $this->note]);

        return $dataProvider;
    }
}
