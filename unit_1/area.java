class Area {
    static float main(float a) {
        return a * a;
    }

    static float main(float a, float b) {
        return a * b;
    }

    static float main(int a, int b) {
        return 0.5f * a * b;
    }
    
    public static void main(String args[]) {
        System.out.println(main(3,4));
    }
}
