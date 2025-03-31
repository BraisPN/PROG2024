public enum Conector {
    HDMI("HDMI"),VGA("VGA"),DisplayPort("DisplayPort"),USB("USB"),PS2("PS2");

    String conectorString;

    private Conector(String conectorString) {
        this.conectorString = conectorString;
    }

    
}
