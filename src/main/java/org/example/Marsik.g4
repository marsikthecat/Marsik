grammar Marsik;

program: imports (stmt* | class_def | module_def) EOF;

import_decl: IMPORT STRING;
imports: import_decl*;

// All data types
type: INTEGER | CHAR | BOOLEAN | STRING | DOUBLE
    | '-' (INTEGER | DOUBLE);

// Data-Type declaration
type_label: (INT_TYPE | DOUBLE_TYPE | CHAR_TYPE | BOOL_TYPE | STRING_TYPE | NAME)
            ('<' type_label (',' type_label)? '>')?;

// statements
stmt: (var_decl | const_decl | assign_stmt | method_call | function_call | if_stmt | while_stmt | return_stmt
    | funcdef | for_stmt | array_decl | inc_stmt | dec_stmt
    | object_stmt | print_stmt | println_stmt | exit_stmt | expr) NEWLINE*;

// For Strings and Objects: Calling methods
method_call: NAME '.' NAME ('(' arguments? ')' | '()');
function_call: NAME '(' arguments? ')';

// initializing Objects
object_stmt: NAME ('<' type_label (',' type_label)? '>')? NAME? EQUAL NEW NAME ('(' arguments? ')' | '()');

// Declare Variables
var_decl: type_label NAME (EQUAL (type | scan_stmt | method_call | expr))? NEWLINE?;

// Constants (only one time asignable)
const_decl: CONST type_label NAME EQUAL type NEWLINE;

// Asign a Value to the Varible
assign_stmt: NAME EQUAL (type | method_call | expr) NEWLINE?;

// Increment value by 1 or more
inc_stmt: NAME PLUSPLUS INTEGER?;

// Decrement value by 1 or more
dec_stmt: NAME MINUSMINUS INTEGER?;

// Static Array
array_decl: type_label '[' INTEGER ']' NAME EQUAL ('[' (type (',' type)*)? ']' | method_call);

// Functions
funcdef: FUNCTION function_signature NEWLINE* block;
function_signature: type_label? NAME (LPAR parameters? RPAR | '()');
parameters: parameter (COMMA parameter)*;
parameter: type_label NAME;

// Control Flows
if_stmt: IF '(' expr ')' block (ELSE block)?;
while_stmt: WHILE '(' expr ')' NEWLINE* block;
block: '{' NEWLINE* stmt* '}';
for_stmt: FOR '(' for_init? ';' expr? ';' for_update? ')' block;
for_init: var_decl | assign_stmt;
for_update: inc_stmt | dec_stmt;
return_stmt: RETURN expr?;

// build in:
print_stmt: PRINT '(' print_arg (',' print_arg)* ')';
println_stmt: PRINTLN '(' print_arg (',' print_arg)* ')';
scan_stmt: SCAN '(' print_arg (',' print_arg)* ')';
print_arg: STRING | expr;
exit_stmt: EXIT ( '(' INTEGER? ')' | '()' );
arguments: expr (',' expr)*;

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
atom_expr : method_call | function_call | NAME | INTEGER | CHAR
          | STRING | DOUBLE | BOOLEAN | '(' expr ')' ;

class_def: 'class' NAME ('{' class_member* '}' | function_call*);
module_def: MODULE NAME '{' funcdef* '}';
class_member: (field_decl | method_decl | funcdef | constructor_decl) NEWLINE*;
field_decl: ('public')? 'const'? type_label NAME;
method_decl: ('internal')? function_signature NEWLINE* block;
constructor_decl: 'Constructor' '(' parameters? ')' block;

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
MODULE   : 'module';
IMPORT   : 'import';
ELSE     : 'else';
FOR      : 'for';
IF       : 'if';
PRINT    : 'print';
PRINTLN  : 'printLine';
RETURN   : 'return';
WHILE    : 'while';
EXIT     : 'exit';
CONST    : 'const';
SCAN     : 'scan';
AR_TYPE     : 'array';
INT_TYPE    : 'int';
DOUBLE_TYPE : 'double';
CHAR_TYPE   : 'char';
BOOL_TYPE   : 'boolean';
STRING_TYPE : 'string';

// primitve datatypes
INTEGER: NON_ZERO_DIGIT DIGIT* | '0';
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