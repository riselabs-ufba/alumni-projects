<?php

namespace app\models;

use Yii;
use yii\base\Model;
use yii\data\ActiveDataProvider;
use app\models\Poc;

/**
 * PocSearch represents the model behind the search form about `app\models\Poc`.
 */
class PocSearch extends Poc
{
    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['id', 'previous_duration', 'real_duration', 'fk_oportunity', 'product_id'], 'integer'],
            [['person_name', 'final_status'], 'safe'],
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
        $query = Poc::find();

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
            'previous_duration' => $this->previous_duration,
            'real_duration' => $this->real_duration,
            'fk_oportunity' => $this->fk_oportunity,
            'product_id' => $this->product_id,
        ]);

        $query->andFilterWhere(['like', 'person_name', $this->person_name])
            ->andFilterWhere(['like', 'final_status', $this->final_status]);

        return $dataProvider;
    }
}
