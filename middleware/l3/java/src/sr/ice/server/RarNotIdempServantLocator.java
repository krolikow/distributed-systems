package sr.ice.server;

import com.zeroc.Ice.Current;
import com.zeroc.Ice.ServantLocator;

public class RarNotIdempServantLocator implements ServantLocator {
    long startId = 1;
    RarNotIdempI rarNotIdempI;

    public LocateResult locate(Current current) {
        long id = startId++;
        rarNotIdempI = new RarNotIdempI(id);
        return new LocateResult(rarNotIdempI, null);
    }

    public void finished(Current current, com.zeroc.Ice.Object servant, Object cookie) {
    }

    public void deactivate(String category) {
    }
}
