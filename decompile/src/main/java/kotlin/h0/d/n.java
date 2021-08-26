package kotlin.h0.d;

import java.util.Arrays;

public class n {
    private n() {
    }

    public static boolean a(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    public static boolean b(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(str + " must not be null");
            l(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void e(Object obj) {
        if (obj == null) {
            o();
            throw null;
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(str + " must not be null");
            l(nullPointerException);
            throw nullPointerException;
        }
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            r(str);
            throw null;
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            q(str);
            throw null;
        }
    }

    public static int i(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private static String j(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }


    private static <T extends Throwable> T l(T t) {
        m(t, n.class.getName());
        return t;
    }

    static <T extends Throwable> T m(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static String n(String str, Object obj) {
        return str + obj;
    }

    public static void o() {
        NullPointerException nullPointerException = new NullPointerException();
        l(nullPointerException);
        throw nullPointerException;
    }


    private static void q(String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(j(str));
        l(illegalArgumentException);
        throw illegalArgumentException;
    }

    private static void r(String str) {
        NullPointerException nullPointerException = new NullPointerException(j(str));
        l(nullPointerException);
        throw nullPointerException;
    }


}