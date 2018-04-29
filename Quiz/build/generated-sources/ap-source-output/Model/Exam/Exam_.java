package Model.Exam;

import Model.Question.Question;
import Model.SousCategorie.SousCategorie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-29T19:25:18")
@StaticMetamodel(Exam.class)
public class Exam_ { 

    public static volatile SingularAttribute<Exam, SousCategorie> sc;
    public static volatile SingularAttribute<Exam, Long> idExam;
    public static volatile SingularAttribute<Exam, String> libelle;
    public static volatile ListAttribute<Exam, Question> questions;

}