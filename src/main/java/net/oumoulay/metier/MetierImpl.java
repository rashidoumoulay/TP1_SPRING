package net.oumoulay.metier;
import net.oumoulay.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("m")
//@Service("m")
public class MetierImpl implements IMetier {
    @Autowired @Qualifier("d2") //d'ici on peut controlé
    private IDao dao; //couplage faible
    /*
         Pour injecter dans l'attribue dao
         un objet de type IDao (d'un class qui implimente IDao)
         au moment de l'instantiation
         ** le plus rapide **
    */
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 20 * Math.PI * Math.cos(t);
        return res;
    }

    /*
         Pour injecter dans l'attribue dao
         un objet de type IDao (d'un class qui implimente IDao)
    */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}

