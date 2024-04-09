import sys
import time
import Ice
import Demo


def close(communicator, exit_code):
    communicator.destroy()
    exit(exit_code)


def reconnect():
    base = communicator.stringToProxy(f"rarIdemp/rarIdemp:{path}")
    Demo.RarIdempPrx.checkedCast(base)
    print("Connection restored.")


path = "tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z"

if __name__ == '__main__':
    communicator = Ice.initialize(sys.argv)
    print("Client started")
    while True:
        try:
            args = input("\nEnter one of commands below:\nRNI [string]\nFNI"
                         "\nFI [int] [int]\nRI [int]\n>>")
            args_split = args.split()
            print(args_split)
            if len(args_split) == 0:
                continue
            if args_split[0] == "RNI" and len(args_split) == 2:
                base = communicator.stringToProxy(f"rarNotIdemp/rarNotIdemp:{path}")
                rni = Demo.RarNotIdempPrx.checkedCast(base)
                if not rni:
                    print("Invalid proxy.")
                    close(communicator, 1)
                result = rni.processData(args_split[1])
                print(f"Processing string {args_split[1]}")
            elif args_split[0] == "FNI" and len(args_split) == 1:
                base = communicator.stringToProxy(f"freqNotIdemp/freqNotIdemp:{path}")
                fni = Demo.FreqNotIdempPrx.checkedCast(base)
                if not fni:
                    print("Invalid proxy.")
                    close(communicator, 1)
                result = fni.getFibb()
                print(f"Next factor of fibonacci sequence: {result}")
            elif args_split[0] == "RI" and len(args_split) == 2:
                base = communicator.stringToProxy(f"rarIdemp/rarIdemp:{path}")
                ri = Demo.RarIdempPrx.checkedCast(base)
                if not ri:
                    print("Invalid proxy.")
                    close(communicator, 1)
                try:
                    n = args_split[1]
                    n = int(n)
                    if n < 0:
                        raise ValueError
                except ValueError:
                    print("Second argument must be a positive number!")
                    continue
                result = ri.getData(n)
                print(f"Element of index {n} is {result}")
            elif args_split[0] == "FI" and len(args_split) == 3:
                base = communicator.stringToProxy(f"freqIdemp/freqIdemp:{path}")
                try:
                    a, b = args_split[1:]
                    a = int(a)
                    b = int(b)
                except ValueError:
                    print("Second and third argument must be a number!")
                    continue
                fi = Demo.FreqIdempPrx.checkedCast(base)
                if not fi:
                    print("Invalid proxy.")
                    close(communicator, 1)
                result = fi.add(a, b)
                print(f"Sum of {a} and {b} is {result}")
            elif args_split[0] == "x":
                close(communicator, 0)
            else:
                print("Invalid input.")
        except Ice.ConnectionRefusedException:
            print("Connection down. Trying to reconnect...")
            connected = False
            while not connected:
                try:
                    reconnect()
                    connected = True
                except Ice.ConnectionRefusedException:
                    time.sleep(3)
                    continue
