package Model.Question;

import Model.Choix.Choix;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-25T20:28:37")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, Integer> idQuestion;
    public static volatile SingularAttribute<Question, String> libelle;
    public static volatile ListAttribute<Question, Choix> choix;

}