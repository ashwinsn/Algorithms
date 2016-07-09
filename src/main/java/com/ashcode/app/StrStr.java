package com.ashcode.app;

/**
 * Created by anatarajan on 12/15/15.
 */
/* When u search and stop because of inequality, where to start again from?
*  S = abcabcde
*  C = abcde
*
*  Since you have searched and stopped after a while, you just encountered a
*  prefix of C. So you need not compare them again. Look out for prefixes of
*  C in S. That's where we can save comparisons.
*
*  store where are all the prefixes of C start in S and how
*  far they go.
*
*  Compare a character i in S to the next compared prefix character in C, if
*
*/
public class StrStr {
}
