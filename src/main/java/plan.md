procedual approach: 

type Person {
    string name
    int age
}

int a = 5
string str
str = "hey"

double[] a = {1.0,2.3,3.5}

/* from stl */
int pi = Math.pi() 

function makeOlder(Person person) {
    person.age++
}

function int setAge(Person person, int newAge) {
    person.age = newAge
    return newAge
}

Person person = ("Bob", 21)
setAge(person, 49)
makeOlder(person)
print(person.age)

/* from stl */
List<Person> list = init_List();
list.add(person)

MyList l = init_MyList();

type MyBetterList {
    List<int> list
    int length
    boolean containsDuplicates
}

function MyBetterList init_MyList() {
    /* from stl */
    List<int> list = init_List();
    MyBetterList betterList = (list, 0, false)
    return betterList
}



