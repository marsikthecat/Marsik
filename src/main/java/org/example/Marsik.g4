grammar Marsik;

program: (stmt* | class_def) EOF;

// TODO Now: Implement Runtimetests for all features
// TODO soon: introduce long type and baby_int for only small integers (0-255)
// TODO later: implement methods and classes with multiple files support
// TODO far in the future (optional): merge var_decl with build_in_stmt, Other_stmt

// All data types
type: INTEGER | BABY_INTEGER | CHAR | BOOLEAN | STRING | DOUBLE;

// Data-Type declaration
type_label: INT_TYPE | DOUBLE_TYPE | CHAR_TYPE | BOOL_TYPE | STRING_TYPE | AR_TYPE | CRYPTODATA_TYPE;

// statements
stmt: (var_decl | const_decl | assign_stmt | if_stmt | while_stmt | return_stmt | expr
    | funcdef | for_stmt | array_decl | build_in_stmt | inc_stmt | dec_stmt
    | object_stmt | method_call | print_stmt | printLn_stmt | exit_stmt) NEWLINE*;

// For Strings and Objects: Calling methods
method_call: NAME '.' NAME '(' arguments? ')';

// initializing Objects
object_stmt: NAME ('<' type_label '>')? NAME EQUAL NEW NAME '(' arguments? ')';

// build in functions
build_in_stmt: type_label NAME EQUAL (scan_stmt | time_stmt | other_stmt | method_call);

// Declare Variables
var_decl: type_label NAME (EQUAL (type | expr))? NEWLINE?;

// Constants (only one time asignable)
const_decl: CONST type_label NAME EQUAL type NEWLINE;

// Asign a Value to the Varible
assign_stmt: NAME EQUAL (type | expr);

// Increment value by 1 or more
inc_stmt: NAME PLUSPLUS INTEGER?;

// Decrement value by 1 or more
dec_stmt: NAME MINUSMINUS INTEGER?;

// Static Array
array_decl: type_label '[' INTEGER ']' NAME EQUAL '[' (type (',' type)*)? ']';

// Functions
funcdef: FUNCTION NAME LPAR parameters? RPAR NEWLINE* block;
parameters: parameter (COMMA parameter)*;
parameter: type NAME;

// Control Flows
if_stmt: IF '(' expr ')' block (ELSE block)?;
while_stmt: WHILE '(' expr ')' NEWLINE* block;
block: '{' stmt* NEWLINE '}';
for_stmt: FOR '(' for_init? ';' expr? ';' for_update? ')' block;
for_init: var_decl | assign_stmt;
for_update: inc_stmt | dec_stmt;

// build in:
print_stmt: PRINT '(' (STRING | expr) ')';
printLn_stmt: PRINTLN '(' (STRING | expr) ')';
exit_stmt: EXIT ( '(' INTEGER? ')' | '()' );
scan_stmt: SCAN '(' STRING ')';
time_stmt: TIME_MILLIS '()';
other_stmt: STANDARDLIBS DOT NAME '(' arguments? ')';
arguments: expr (',' expr)*;
return_stmt: RETURN expr?;

// Arithmetic stuff and operations
expr: or_expr;
or_expr : and_expr ('or' and_expr)* ;
and_expr : equality_expr ('and' equality_expr)* ;
equality_expr : relational_expr (('==' | '!=') relational_expr)* ;
relational_expr : additive_expr (('<'|'>'|'<='|'>=') additive_expr)* ;
additive_expr : multiplicative_expr (('+'|'-') multiplicative_expr)* ;
multiplicative_expr : unary_expr (('*'|'/'|'%') unary_expr)* ;
unary_expr : ('+'|'-'|'not') unary_expr | power_expr ;
power_expr : atom_expr ('**' unary_expr)? ;
atom_expr : other_stmt | NAME | INTEGER | BABY_INTEGER | CHAR
          | STRING | DOUBLE | BOOLEAN | '(' expr ')' ;

class_def: 'class' NAME '{' class_member* '}';
class_member: field_decl | constructor_decl | method_decl;
field_decl: ('public')? 'const'? type NAME;
constructor_decl: '_constructor' '(' parameters? ')' block;
method_decl: ('internal')? 'Method' (':' type)? NAME '(' parameters? ')' block;

// They offer static methods
STANDARDLIBS     : 'Sys' | 'Math' | 'FileHandler' | 'Crypto' | 'Validator' | 'Threads' | 'DateTime'
                   | 'RequestSender' | 'TypeCaster';

// TODO: Thread support (maybe)

PLUSPLUS         : '++';
MINUSMINUS       : '--';
LSQB             : '[';
RSQB             : ']';
COMMA            : ',';
SEMI             : ';';
EQUAL            : '=';
LPAR             : '(';
LBRACE           : '{';
RPAR             : ')';
RBRACE           : '}';
COLON            : ':';
PLUS             : '+';
MINUS            : '-';
STAR             : '*';
SLASH            : '/';
VBAR             : '|';
AMPER            : '&';
LESS             : '<';
GREATER          : '>';
DOT              : '.';
PERCENT          : '%';
BACKQUOTE        : '`';
EQEQUAL          : '==';
INEQUAL          : '<>';
NOTEQUAL         : '!=';
LESSEQUAL        : '<=';
GREATEREQUAL     : '>=';
TILDE            : '~';
CIRCUMFLEX       : '^';
LEFTSHIFT        : '<<';
RIGHTSHIFT       : '>>';
DOUBLESTAR       : '**';
PLUSEQUAL        : '+=';
MINEQUAL         : '-=';
STAREQUAL        : '*=';
SLASHEQUAL       : '/=';

// Keywords
NEW      : 'new';
BREAK    : 'break';
FUNCTION : 'function';
ELSE     : 'else';
FOR      : 'for';
IF       : 'if';
PRINT    : 'print';
PRINTLN  : 'printLine';
RETURN   : 'return';
TRY      : 'try';
WHILE    : 'while';
EXIT     : 'exit';
CONST    : 'const';
SCAN     : 'scan';
TIME_MILLIS : 'getTime';
AR_TYPE     : 'array';
INT_TYPE    : 'int';
DOUBLE_TYPE : 'double';
CHAR_TYPE   : 'char';
BOOL_TYPE   : 'boolean';
STRING_TYPE : 'string';

// specific non-primitive Types
CRYPTODATA_TYPE : 'CryptoData';

// primitve datatypes
INTEGER: NON_ZERO_DIGIT DIGIT* | '0';
BABY_INTEGER: [1-9] | [1-9][0-9] | '1'[0-9][0-9]
    | '2'[0-4][0-9] | '25'[0-5];
STRING: '"' ( CHAR | ESC | ~["\\\r\n] )* '"' ;
CHAR: '\'' (LETTER | ESC) '\'';
DOUBLE : INT_PART '.' DIGIT+;
BOOLEAN: 'true' | 'false';

NAME: (LETTER) (LETTER | DIGIT)*;
NEWLINE: '\r'? '\n';
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
WS: [ \t\r\n]+ -> skip;

fragment NON_ZERO_DIGIT : [1-9];
fragment INT_PART       : DIGIT+;
fragment ESC            : '\\' [ntr"\\];
fragment LETTER     : LOWERCASE | UPPERCASE;
fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];
fragment DIGIT      : [0-9];