# Expression Parsing Using Stack
Table of Contents
---
1. [Precedence of the operators](#precedence-of-the-operators)
2. [Infix to Postfix using Stack](#using-stack)

#### Precedence of the operators
1. () {} []  
2. ^  Right to Left
3. (/), (*) Left to Right
4. (-), (+) Left to Right
#### Rules for converting infix to another form
1. Maintain precedence. Operation with higher precedence will be occured first.
2. If precedence is same check associativity	


#### Infix to Postfix Conversion
1. operands will go to last for one particular operation
![](expression_parsing_২০২৪০৩২৪১৯৩৩০৩১২৭.png)
2. for more than one operation precedence will be followed
![](expression_parsing_২০২৪০৩২৪১৯৩৫৫০৩৫০.png)

## Using Stack
*Rules*
1. Operands will go to the output directly without any operation and if the stack is empty or stack top is a opening bracket then operator will be pushed to the stack.If the incoming symbol is '(' then it will be pushed to the stack always.
	+ ![](expression_parsing_২০২৪০৩২৪২২০৪২৪৩১১.png)

2.  If the incoming symbol is ')' then pop the stack send the symbols to the output until its opening one '('.
	+ For example, if the stack is like this
	+ ![](expression_parsing_২০২৪০৩২৪২০১২৫৮৫১০.png) 
	+ and the incoming symbol is ')' then 
	+ ![](expression_parsing_২০২৪০৩২৪২০১৬০৪৩১০.png)
	+ parenthesis will not go to the output, these will be discarded.

3. If the incoming symbol has higher precedence than the top of the stack then it will be pushed to the stack else pop the stack and send to the output until you get symbol with lower precedence or stack becomes empty and lastly push the incoming symbol.
	+ higher precedence than top of the stack : pushed to the stack
	+ lower precedence than top of the stack : pop the stack and send to the output until getting symbol with lower precedence or stack becoming empty then push

4. If the incoming symbol has the same precedence of the top of the stack then check associativity rule. 
	+ For Left to Right follow the rule of lower precedence
	+ For Right to Left follow the rule of higher precedence

*Reading the input from left to right*

Input : `a+b*c-((a-b)*c)+(a+b)`

Output : *(empty)*

```
in> a+b*c-((a-b)*c)+(a+b)
stack > (empty)
out> `a`

in > +b*c-((a-b)*c)+(a+b)
stack > +
out > a

in > b*c-((a-b)*c)+(a+b)
stack > +
out > ab

in > *c-((a-b)*c)+(a+b)
stack > +*    // * > +
out > ab

in > c-((a-b)*c)+(a+b)
stack > +*
out > abc

in > -((a-b)*c)+(a+b)
stack > -
out > abc*+   // - < * and for (-) and (+) left to right associativity

in > ((a-b)*c)+(a+b)
stack > -(
out > abc*+

in > (a-b)*c)+(a+b)
stack > -((
out > abc*+

in > a-b)*c)+(a+b)
stack > -((
out > abc*+a

in > -b)*c)+(a+b)
stack > -((-
out > abc*+a

in > b)*c)+(a+b)
stack > -((-
out > abc*+ab

in > )*c)+(a+b)
stack > -(
out > abc*+ab-

in > *c)+(a+b)
stack > -(*
out > abc*+ab-

in > c)+(a+b)
stack > -(*
out > abc*+ab-c

in > )+(a+b)
stack > -
out > abc*+ab-c*

in > +(a+b)
stack > +
out > abc*+ab-c*-

in > (a+b)
stack > +(
out > abc*+ab-c*-

in > a+b)
stack > +(
out > abc*+ab-c*-a

in > +b)
stack > +(+
out > abc*+ab-c*-a

in > b)
stack > +(+
out > abc*+ab-c*-ab

in > )
stack > +
out > abc*+ab-c*-ab+

in > (empty)
stack > 
out > abc*+ab-c*-ab++
```

