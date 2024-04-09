package sr.ice.server;

import com.zeroc.Ice.*;
import java.lang.Exception;


public class IceServer {
	public void t1(String[] args) {
		int status = 0;
		Communicator communicator = null;

		try {
			communicator = Util.initialize(args);

			ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("DemoAdapter", "tcp -h 127.0.0.2 -p 10000 -z -t 10000 : udp -h 127.0.0.2 -p 10000 -z");

			FreqNotIdempI freqNotIdempI = new FreqNotIdempI(1);
			FreqIdempI freqIdempI = new FreqIdempI(1);
			RarIdempI rarIdempI = new RarIdempI(1);
			RarNotIdempServantLocator rarNotIdempServantLocator = new RarNotIdempServantLocator();

			adapter.add(freqNotIdempI, new Identity("freqNotIdemp", "freqNotIdemp"));
			adapter.addDefaultServant(freqIdempI,"freqIdemp");
			adapter.addDefaultServant(rarIdempI, "rarIdemp");
			adapter.addServantLocator(rarNotIdempServantLocator, "rarNotIdemp");

			adapter.activate();

			System.out.println("Entering event processing loop...");

			communicator.waitForShutdown();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			status = 1;
		}
		if (communicator != null) {
			try {
				communicator.destroy();
			} catch (Exception e) {
				e.printStackTrace(System.err);
				status = 1;
			}
		}
		System.exit(status);
	}


	public static void main(String[] args) {
		IceServer app = new IceServer();
		app.t1(args);
	}
}