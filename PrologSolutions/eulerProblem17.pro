%If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
%
%If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?



digit(1, one).
digit(2, two).
digit(3, three).
digit(4, four).
digit(5, five).
digit(6, six).
digit(7, seven).
digit(8, eight).
digit(9, nine).
digit(10, ten).
digit(11, eleven).
digit(12, twelve).
digit(13, thirteen).
digit(14, fourteen).
digit(15, fifteen).
digit(16, sixteen).
digit(17, seventeen).
digit(18, eighteen).
digit(19, nineteen).
tens(2, twenty).
tens(3, thirty).
tens(4, fourty).
tens(5, fifty).
tens(6, sixty).
tens(7, seventy).
tens(8, eighty).
tens(9, ninty).


%Parse int returns english text of int X from 1 to 1000.

parseInt(1000, [one, thousand]). %Special case for 1000.
parseInt(0, []). %Edge/Return Case
parseInt(Int, [Result]):-% 1-19 Case
        Int/20 < 1, 
        digit(Int, Result).
parseInt(Int, [H|T]):-%20 - 99 case
        Int/100 < 1,
        Tens is floor(Int / 10),
        Rem is mod(Int, 10),
        tens(Tens, H),
        parseInt(Rem, T).
parseInt(Int, [H1, 'hundred'|T]):- %100,200,300... case
        Int/1000 < 1,
        0 is mod(Int, 100),
        Hundreds is floor(Int/100),
        digit(Hundreds, H1),
        parseInt(0, T).
parseInt(Int, [H1, 'hundred', 'and'|T]):- %100 - 999
        Int/1000 < 1,
        Hundreds is floor(Int / 100),
        Rem is mod(Int, 100),
        digit(Hundreds, H1),
        parseInt(Rem, T).

countLetters(Atom, Result):-
        atom_chars(Atom, Tmp), 
        length(Tmp, Result).
 
countLetterNum(List, Result):-
        countLetterNum(List, 0, Result).

countLetterNum([], R, R).
countLetterNum([H|T], Acc, Result):-
        countLetters(H, Count),
        Acc2 is Acc + Count,
        countLetterNum(T, Acc2, Result).
        

solver(Int, Result) :-
        solver(Int, 0, Result).

solver(0, R, R).
solver(Int, Acc, Result):-
        parseInt(Int, List),
        countLetterNum(List, Count),
        Acc2 is Acc + Count,
        NewInt is Int - 1,
        solver(NewInt, Acc2, Result).
