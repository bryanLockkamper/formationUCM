package models.Plateau;
import models.unite.Paysan;
import java.util.ArrayList;

public class CaseSpecial<T> extends Case<T> {

    private ArrayList<Paysan> paysans;

    public CaseSpecial(T content) {
        super(content,false,true);
    }

    public ArrayList<Paysan> getPaysans() {
        return paysans;
    }

    public void setPaysans(ArrayList<Paysan> paysans) {
        this.paysans = paysans;
    }
}
