// Taken from https://www.geeksforgeeks.org/asynchronous-synchronous-callbacks-java/


// Java program to illustrate synchronous callback
interface OnGeekEventListener {

    // this can be any type of method
    void onGeekEvent();
}

class Callbacks {

    // only one listener but this could be a list
    private OnGeekEventListener mListener; // listener field

    // setting the listener
    public void registerOnGeekEventListener(OnGeekEventListener mListener)
    {
        this.mListener = mListener;
    }

    // my synchronous task
    public void doGeekStuff()
    {

        // SYNC VERSION
        // perform any operation
        System.out.println("Performing callback before synchronous Task");

        // check if listener is registered.
        if (this.mListener != null) {

            // invoke the callback method of class A
            mListener.onGeekEvent();
        }

        // perform any operation
        System.out.println("Performing operation in Asynchronous Task");
        //ASYNC VERSION
        // An Async task always executes in new thread
        new Thread(new Runnable() {
            public void run()
            {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // check if listener is registered.
                if (mListener != null) {

                    // invoke the callback method of class A
                    mListener.onGeekEvent();
                }
            }
        }).start();
    }

    // Driver Function
    public static void main(String[] args)
    {
        Callbacks obj = new Callbacks();
        OnGeekEventListener mListener = new AA();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();
    }
}

class AA implements OnGeekEventListener {

    @Override
    public void onGeekEvent()
    {
        System.out.println("Performing callback after synchronous Task from AA");
        // perform some routine operation
    }
    // some class A methods
}
