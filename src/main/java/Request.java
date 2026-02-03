public class Request {
    private final String action;
    private int id = -1;

    public Request(String cmd) {
        String[] cmdBits = cmd.split("\\?", 2);
        this.action = cmdBits[0];

        if (cmdBits.length == 2) {
            String[] paramBits = cmdBits[1].split("=");
            this.id = Integer.parseInt(paramBits[1]);
        }
    }

    public String getAction() {
        return action;
    }

    public int getId() {
        return id;
    }
}