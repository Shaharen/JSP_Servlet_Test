create table book_member(
 id varchar2(50),
 pw varchar2(50) not null,
 nick varchar2(50),
 email varchar2(50),
 tel varchar2(50),
 constraint pk_book_member primary key(id)
 );
 
select * from book_member
 