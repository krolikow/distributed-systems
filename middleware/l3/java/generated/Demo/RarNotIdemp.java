//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `demo.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Demo;

public interface RarNotIdemp extends com.zeroc.Ice.Object
{
    void processData(String dataSeq, com.zeroc.Ice.Current current) throws InterruptedException;

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Demo::RarNotIdemp",
        "::Ice::Object"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::Demo::RarNotIdemp";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_processData(RarNotIdemp obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current) throws InterruptedException {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        String iceP_dataSeq;
        iceP_dataSeq = istr.readString();
        inS.endReadParams();
        obj.processData(iceP_dataSeq, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "processData"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 1:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 2:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 3:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 4:
            {
                try {
                    return _iceD_processData(this, in, current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}