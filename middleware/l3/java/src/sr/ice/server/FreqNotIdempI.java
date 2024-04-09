package sr.ice.server;

import Demo.FreqNotIdemp;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Util;

public class FreqNotIdempI implements FreqNotIdemp {
    private int a = 1;
    private int b = 1;
    private final long id;

    public FreqNotIdempI(long id) {
        System.out.printf("[FreqNotIdemp] Servant with id: %x created\n",id);
        this.id = id;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public int getFibb(Current current) {
        int tmp = this.a + this.b;
        setA(this.b);
        setB(tmp);
        System.out.printf("[FreqNotIdemp] Servant id: %x, Object id: %s " +
                        "- getting next factor of fibonacci sequence\n"
                ,this.id, Util.identityToString(current.id));
        return this.b;
    }
}
