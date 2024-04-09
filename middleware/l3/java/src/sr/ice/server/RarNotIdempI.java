package sr.ice.server;

import Demo.RarNotIdemp;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Util;


public class RarNotIdempI implements RarNotIdemp {
    private final long id;

    public RarNotIdempI(long id) {
        System.out.printf("[RarNotIdemp] Servant with id: %x created\n",id);
        this.id = id;
    }

    @Override
    public void processData(String dataSeq, Current current) throws InterruptedException {
        System.out.printf("[RarNotIdemp] Servant id: %x, Object id: %s -" +
                " processing data\n",this.id, Util.identityToString(current.id));
        Thread.sleep(6000);
    }
}
