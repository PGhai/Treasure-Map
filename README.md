# Treasure-Map-Problem-Using_Backtracking
Given an array of two symbols find the map, starting from top left to bottom right or any position to find the treasure marked as any other symbol.

The problem statement is as follows:

Given an 2d array of three symbols the program is aim to find the symbol used to mark a treasure in the map.

For more clarity, 

Example,
---#--###----
-#---#----##-
####-#-#-#-##
---#---#-#---
-#-####---##-
-#------#----
-############
------------@

"-" : Path we can walk
"#" : Obstruction, we must turn
"@" : treasure


Desired Out put:
This is my challenge:
---#--###--#-
-#---#----##-
####-#-#-#-##
---#---#-#---
-#-####---##-
-#------#----
-############
------------@
Woo hoo, I found the treasure :-)
+++#--###--#-
!#+++#+++-##-
####+#+#+#!##
+++#+++#+#!!!
+#+####++!##!
+#++++++#!!!!
+############
++++++++++++@


Another example,

This is my challenge:
---#--###--#@
-#---#----##-
####-#-#-#-##
---#---#-#---
-#-####---##-
-#------#----
-############
-------------
Uh oh, I could not find the treasure :-(
!!!#!!###!!#@
!#!!!#!!!!##-
####!#!#!#!##
!!!#!!!#!#!!!
!#!####!!!##!
!#!!!!!!#!!!!
!############
!!!!!!!!!!!!!

Thanks!
