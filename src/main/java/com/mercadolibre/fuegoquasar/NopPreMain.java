package com.mercadolibre.fuegoquasar;

import java.lang.instrument.Instrumentation;

public class NopPreMain {

    private NopPreMain() {
        // No instances
    }

    public static void premain(final String opts, final Instrumentation inst) {
    }
}
