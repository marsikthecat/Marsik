grammar Marsik;

program: stmt* EOF;

stmt: var_decl | const_decl | assign_stmt
    | if_stmt | while_stmt | for_stmt | return_stmt | funcdef
    | print_stmt | println_stmt | scan_stmt | exit_stmt
    | method_call | object_stmt | expr | class_def | NEWLINE;

block: '{' NEWLINE* stmt* NEWLINE* '}';

var_decl: NAME ('=' (scan_stmt | method_call | object_stmt | expr))? NEWLINE?;
const_decl: CONST NAME '=' expr NEWLINE?;
assign_stmt: NAME '=' (method_call | object_stmt | expr) NEWLINE?;

funcdef: FUNCTION NAME '(' parameters? ')' block;
parameters: parameter (COMMA parameter)*;
parameter: NAME;

if_stmt: IF '(' expr ')' block (ELSE block)?;
while_stmt: WHILE '(' expr ')' block;
for_stmt: FOR '(' for_init? ';' expr? ';' for_update? ')' block;
for_init: var_decl | assign_stmt;
for_update: inc_stmt | dec_stmt;
return_stmt: RETURN expr? NEWLINE?;

inc_stmt: NAME PLUSPLUS NUMBER?;
dec_stmt: NAME MINUSMINUS NUMBER?;

print_stmt: PRINT '(' print_arg (COMMA print_arg)* ')';
println_stmt: PRINTLN '(' print_arg (COMMA print_arg)* ')';
scan_stmt: SCAN '(' print_arg (COMMA print_arg)* ')';
print_arg: expr;
exit_stmt: EXIT ('(' NUMBER? ')' | '()')?;

method_call: NAME (DOT NAME ('(' arguments? ')')?)*;
arguments: expr (COMMA expr)*;

expr: or_expr;
or_expr: and_expr (OR and_expr)*;
and_expr: equality_expr (AND equality_expr)*;
equality_expr: relational_expr (('==' | '!=') relational_expr)*;
relational_expr: additive_expr (('<' | '>' | '<=' | '>=') additive_expr)*;
additive_expr: multiplicative_expr (('+' | '-') multiplicative_expr)*;
multiplicative_expr: unary_expr (('*' | '/' | '%') unary_expr)*;
unary_expr: ('+' | '-' | NOT) unary_expr | power_expr;
power_expr: atom ('**' unary_expr)?;
atom: NUMBER | STRING | BOOL | NULL_LITERAL | method_call | '(' expr ')' *
     | array_literal;

array_literal: '[' (expr (COMMA expr)*)? ']';

class_def: CLASS NAME '{' class_member* '}';
class_member: (field_decl | method_decl | constructor_decl) NEWLINE*;
field_decl: ('public' | 'private')? 'const'? NAME ('=' expr)?;
method_decl: ('internal')? 'Method:' NAME '(' parameters? ')' block;
constructor_decl: 'Constructor' '(' parameters? ')' block;

object_stmt: NAME '=' NEW NAME ('(' arguments? ')')?;

PLUSPLUS: '++';
MINUSMINUS: '--';
COMMA: ',';
SEMI: ';';
EQUAL: '=';
LPAR: '(';
RPAR: ')';
LBRACE: '{';
RBRACE: '}';
COLON: ':';
DOT: '.';
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
PERCENT: '%';
LESS: '<';
GREATER: '>';
EQEQUAL: '==';
NOTEQUAL: '!=';
LESSEQUAL: '<=';
GREATEREQUAL: '>=';
DOUBLESTAR: '**';

NEW: 'new';
BREAK: 'break';
FUNCTION: 'function';
ELSE: 'else';
FOR: 'for';
IF: 'if';
PRINT: 'print';
PRINTLN: 'printLine';
RETURN: 'return';
WHILE: 'while';
EXIT: 'exit';
CONST: 'const';
SCAN: 'scan';
CLASS: 'class';
AND: 'and';
OR: 'or';
NOT: 'not';
NULL_LITERAL: 'null';
BOOL: 'true' | 'false';

NUMBER: '0' | NON_ZERO_DIGIT DIGIT*;
STRING: '"' (ESC | ~["\\\r\n])* '"' | '\'' (ESC | ~['\\\r\n])* '\'' ;
NAME: LETTER (LETTER | DIGIT)*;
NEWLINE: '\r'? '\n';
COMMENT: '/*' .*? '*/' -> skip;
WS: [ \t]+ -> skip;

fragment NON_ZERO_DIGIT: [1-9];
fragment ESC: '\\' [ntr"'\\];
fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];