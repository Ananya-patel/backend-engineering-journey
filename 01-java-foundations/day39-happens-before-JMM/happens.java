int data = 0;
volatile boolean flag = false;

Thread A:
data = 100;
flag = true;

Thread B:
if (flag) {
    System.out.println(data);
}

