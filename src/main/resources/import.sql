INSERT INTO `User` (`userID`, `name`, `email`, `biography`) VALUES (1, 'HAPPY_MAN', 'kao850702@gmail.com', '歡迎您的到訪');
INSERT INTO `Post` (`postID`, `userID`, `content`) VALUES (1, 1, '歡迎造訪此平台');
INSERT INTO `Comment` (`commentID`, `userID`, `postID`, `content`) VALUES (1, 1, 1, '您可以在此留言');
