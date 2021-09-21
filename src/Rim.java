public enum Rim {
    I("I"),
    II("II"),
    III("III"),
    IV("IV"),
    V("V"),
    VI("VI"),
    VII("VII"),
    VIII("VIII"),
    IX("IX"),
    X("X");

    private final String name;
    Rim(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static Rim get(String name) {

        for (Rim n : values()) {
            if (n.getName().equals(name)) {
                return n;
            }
        }
        for (Rim n1 : values()) {
            if (n1.getName().equals(name)) {
                return n1;
            }
        }
        return null;
    }
}

