grammar Marsik;

program: NEWLINE* imports (top_level_item NEWLINE*)* EOF;

import_decl: IMPORT STRING;
imports: (import_decl NEWLINE*)*;
top_level_item: custom_type | function_def | stmt;

// All primitive data types
type: INTEGER | CHAR | BOOLEAN | STRING | DOUBLE | '-' (INTEGER | DOUBLE);

// Data-Type declaration
type_label: (INT_TYPE | DOUBLE_TYPE | CHAR_TYPE | BOOL_TYPE | STRING_TYPE | NAME)
            ('<' type_label (',' type_label)? '>')?;
            
// Custom Types inspired by structs
custom_type: TYPE NAME LBRACE NEWLINE* ((type_label NAME | object_stmt) NEWLINE*)* RBRACE;

// statements
stmt: (object_stmt | var_decl | const_decl | assign_stmt | function_call | if_stmt | while_stmt | return_stmt
    | for_stmt | array_decl | inc_stmt | dec_stmt | print_stmt | println_stmt | exit_stmt | expr) SEMI? NEWLINE*;

// Qualified names support both free functions and methods such as person.getAge().
qualified_name: NAME (DOT NAME)*;
function_call: qualified_name '(' arguments? ')';

// initializing Objects
object_stmt: NAME ('<' type_label (',' type_label)? '>')? NAME EQUAL '(' arguments? ')';

// Declare Variables
var_decl: type_label NAME (EQUAL (type | scan_stmt | function_call | expr))? NEWLINE?;

// Constants (only one time asignable)
const_decl: CONST type_label NAME EQUAL type;

// Asign a Value to the Varible
assign_stmt: qualified_name EQUAL (type | function_call | expr) NEWLINE?;

// Increment value by 1 or more
inc_stmt: qualified_name PLUSPLUS INTEGER?;

// Decrement value by 1 or more
dec_stmt: qualified_name MINUSMINUS INTEGER?;

// Static Array
array_decl: type_label '[' INTEGER? ']' NAME EQUAL
    ('[' (type (',' type)*)? ']' | '{' (type (',' type)*)? '}' | function_call);

// Functions
function_def: FUNCTION return_type=type_label? NAME '(' parameters? ')' block;
parameters: parameter (COMMA parameter)*;
parameter: type_label NAME;

// Control Flows
if_stmt: IF '(' expr ')' block (ELSE block)?;
while_stmt: WHILE '(' expr ')' NEWLINE* block;
block: '{' NEWLINE* (stmt NEWLINE*)* '}';
for_stmt: FOR '(' for_init? ';' expr? ';' for_update? ')' block;
for_init: var_decl | assign_stmt;
for_update: inc_stmt | dec_stmt;
return_stmt: RETURN expr?;

// build in:
print_stmt: PRINT '(' print_arg (',' print_arg)* ')';
println_stmt: PRINTLN '(' print_arg (',' print_arg)* ')';
scan_stmt: SCAN '(' print_arg (',' print_arg)* ')';
print_arg: STRING | expr;
exit_stmt: EXIT '(' INTEGER? ')';
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
atom_expr : function_call | qualified_name | INTEGER | CHAR | STRING | DOUBLE | BOOLEAN | '(' expr ')' ;

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
TYPE     : 'type';
BREAK    : 'break';
FUNCTION : 'function';
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

NAME: (LETTER | '_') (LETTER | DIGIT | '_')*;
NEWLINE: '\r'? '\n';
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
WS: [ \t]+ -> skip;

fragment NON_ZERO_DIGIT : [1-9];
fragment INT_PART       : DIGIT+;
fragment ESC            : '\\' [ntr"\\];
fragment LETTER     : LOWERCASE | UPPERCASE;
fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];
fragment DIGIT      : [0-9];