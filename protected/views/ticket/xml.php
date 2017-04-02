<?php /* BeginFeature:XML */
foreach ($model->getAttributes() as $key => $value) {
    $tagName = str_replace(' ', '', CHtml::encode($model->getAttributeLabel($key)));
    echo '<' . $tagName . '>' . CHtml::encode($value) . '</' . $tagName . '>';
}
foreach ($model->relations() as $relation => $relationValue) {
    echo '<' . $relation . '>';   
    if ($relationValue[0] != 'CBelongsToRelation') {
        foreach ($model->$relation as $key => $relationChild){
            echo '<' . get_class($relationChild) . '>';
            foreach ($relationChild->getAttributes() as $key => $value) {
                $tagName = str_replace(' ', '', CHtml::encode($model->getAttributeLabel($key)));
                echo '<' . $tagName . '>' . CHtml::encode($value) . '</' . $tagName . '>';
            }
            echo '</' . get_class($relationChild) . '>';
        }        
    }else{    
        foreach ($model->$relation->getAttributes() as $key => $value) {
            $tagName = str_replace(' ', '', CHtml::encode($model->getAttributeLabel($key)));
            echo '<' . $tagName . '>' . CHtml::encode($value) . '</' . $tagName . '>';
        }
    }
    echo '</' . $relation . '>';
}
/* EndFeature:XML */

