DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`
(
`userID`        int(11) NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) DEFAULT NULL,
    `email`      varchar(255) DEFAULT NULL,
    `password`   varchar(255) DEFAULT NULL,
    `coverImage` varchar(255) DEFAULT NULL,
    `biography`  varchar(255) DEFAULT NULL,
    `mobile`  varchar(255) DEFAULT NULL,
    PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Post`;
CREATE TABLE `Post`
(
    `postID`    int(11) NOT NULL AUTO_INCREMENT,
    `userID`    int(11)      DEFAULT NULL,
    `content`   text         DEFAULT NULL,
    `createdAt`  date         DEFAULT NULL,
    PRIMARY KEY (`postID`),
    FOREIGN KEY (`userID`) REFERENCES `User`(`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Comment`;
CREATE TABLE `Comment`
(
    `commentID` int(11) NOT NULL AUTO_INCREMENT,
    `userID`    int(11) DEFAULT NULL,
    `postID`    int(11) DEFAULT NULL,
    `content`  text DEFAULT NULL,
    `createdAt` date DEFAULT NULL,
    PRIMARY KEY (`commentID`),
    FOREIGN KEY (`userID`) REFERENCES `User`(`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
