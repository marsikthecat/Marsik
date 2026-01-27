
package org.example;

import org.example.internals.math.Math;
import org.example.internals.FileHandler;
import org.example.internals.crypto.*;
import org.example.internals.TypeCaster;
import org.example.internals.datastructures.*;
import org.example.internals.time.DateTime;


public class GeneratedProgram {
    static void main(String[] args) {
        int a = 5;
double pow = java.lang.Math.pow(a,a);
final double pi = 3.141529;
MarsikString b = new MarsikString("aa");
boolean c = false;
double d = 5.67;
System.out.println("hey, bro");
System.out.println("Your age");
MarsikString age = new MarsikString(new java.util.Scanner(System.in).nextLine());
int ageCasted = TypeCaster.stringToInt(age);
MarsikString time = new MarsikString(String.valueOf(System.currentTimeMillis()));
int timeInInt = TypeCaster.stringToInt(time);
MarsikArray<Character> arr = new MarsikArray<>('a','b');
int firstIndex = arr.indexOf('b');
char e = arr.get(0);
MarsikList<Integer> list1 = new MarsikList<>(4,3,5,4,6,4,3,5,4,6,6);
list1.add(2);
list1.removeDuplicateOf(6);
MarsikString fileContent = new MarsikString(FileHandler.readFile(b));
if (e>Math.gcd(5,12)) {
e++;
}
 else {
e--;
}
for (int x = 0;
x < 5; x++) {
System.out.print(x);
}
int i = 0;
while (i < 5) {
if (Math.isEven(i)) {
i++;
}
}
MarsikString secret = new MarsikString("banana");
secret.append("a");
CryptoData cryptoData = Crypto.generateKey();
CryptoData encrypted = Crypto.encrypt(secret, cryptoData);
MarsikString decrypted = new MarsikString(Crypto.decrypt(encrypted));
if (secret==decrypted) {
System.exit(0);
}
MarsikPerfectHashMap<Character> hashMap = new MarsikPerfectHashMap<>();
hashMap.defineKeys("Letter");
hashMap.set("Letter", e);
MarsikString today = new MarsikString(DateTime.now());
if (DateTime.isLeapYear(today)) {
System.out.print("this year is a leap year");
}
int zz;
zz = 3333;
zz = 32;

    }
}
