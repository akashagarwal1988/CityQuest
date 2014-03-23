CityQuest
=========


<App description here>


Setting up local repo and making code changes 
=============================================


One Time Setup
--------------
1. Make a directory in your local file system called "CityQuest"
2. cd ./CityQuest
3. git init
4. git add remote origin https://github.com/akashagarwal1988/CityQuest.git

-------------------------------------------------------------------------

To push and pull from remote repo
---------------------------------

5. To pull the changes from this repo - git pull origin master
6. If u want to add some changes to this repo. Do a "git add ." in your local repo and then git commit -m "< any commit message >".
Then you can do a "git push origin master"
7. The commands above for push and pull make changes to the master branch as specified. 
For our project we will keep the master branch as the reviewed code branch.
So if you make any changes to the code on your local and want to merge it with master ---
a) Create a new branch with git checkout -b <branch name>
b) push to that branch with git push origin <branch name>
c) Make a pull request as explained here - https://help.github.com/articles/creating-a-pull-request
