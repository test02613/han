use store;

create table member(
	memberId varchar(50),
    memberPw VARCHAR(100) NOT NULL,
	memberName VARCHAR(30) NOT NULL,
	memberMail VARCHAR(100) NOT NULL,
	memberAddr1 VARCHAR(100) NOT NULL,
	memberAddr2 VARCHAR(100) NOT NULL,
	memberAddr3 VARCHAR(100) NOT NULL,
	adminCk int NOT NULL,
	regDate DATE NOT NULL,
	money int NOT NULL,
	point int NOT NULL,
	PRIMARY KEY(memberId)
);