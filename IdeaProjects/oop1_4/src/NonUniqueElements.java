public class NonUniqueElements {
    public IntCollector convert(IntCollector arr){
        int count;
        for (int a:arr.getArray()) {
            count = arr.countOf(a);
            if(count == 1){
                arr.remove(arr.indexOf(a));
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        NonUniqueElements app = new NonUniqueElements();
        int[] v1 = {1,2,3,1,3};
        IntCollector a = new IntCollector(v1);
        a.print();
        System.out.print("→");
        IntCollector ret = app.convert(a);
        ret.print();
        System.out.println();
        int[] v2 = {1,2,3,4,5};
        a = new IntCollector(v2);
        a.print();
        System.out.print("→");
        ret = app.convert(a);
        ret.print();
        System.out.println();
        int[] v3 = {5,5,5,5,5};
        a = new IntCollector(v3);
        a.print();
        System.out.print("→");
        ret = app.convert(a);
        ret.print();
        System.out.println();
        int[] v4 = {10,9,10,10,9,8};
        a = new IntCollector(v4);
        a.print();
        System.out.print("→");
        ret = app.convert(a);
        ret.print();
        System.out.println();
    }
}
