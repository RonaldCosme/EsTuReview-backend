-- Insertando universidades
INSERT INTO University (name, campus, location, description) VALUES ('University A', 'Campus A', 'Location A', 'Description A');
INSERT INTO University (name, campus, location, description) VALUES ('University B', 'Campus B', 'Location B', 'Description B');
INSERT INTO University (name, campus, location, description) VALUES ('University C', 'Campus C', 'Location C', 'Description C');

-- Insertando usuarios
INSERT INTO "User" (name, email, password, university_id, registration_date, role) VALUES ('User A', 'userA@email.com', 'passwordA', 1, CURRENT_DATE, 'student');
INSERT INTO "User" (name, email, password, university_id, registration_date, role) VALUES ('User B', 'userB@email.com', 'passwordB', 2, CURRENT_DATE, 'professor');
INSERT INTO "User" (name, email, password, university_id, registration_date, role) VALUES ('User C', 'userC@email.com', 'passwordC', 3, CURRENT_DATE, 'admin');

-- Insertando cursos
INSERT INTO Course (course_name, course_code, university_id, faculty, description) VALUES ('Course A', 'CodeA', 1, 'Faculty A', 'Description A');
INSERT INTO Course (course_name, course_code, university_id, faculty, description) VALUES ('Course B', 'CodeB', 2, 'Faculty B', 'Description B');
INSERT INTO Course (course_name, course_code, university_id, faculty, description) VALUES ('Course C', 'CodeC', 3, 'Faculty C', 'Description C');

-- Insertando profesores
INSERT INTO Professor (user_id, faculty, join_date) VALUES (1, 'Faculty A', CURRENT_DATE);
INSERT INTO Professor (user_id, faculty, join_date) VALUES (2, 'Faculty B', CURRENT_DATE);
INSERT INTO Professor (user_id, faculty, join_date) VALUES (3, 'Faculty C', CURRENT_DATE);

-- Insertando reviews
INSERT INTO Review (user_id, professor_id, course_id, comment, rating, review_date, status) VALUES (1, 1, 1, 'Comment A', 5, CURRENT_DATE, 'published');
INSERT INTO Review (user_id, professor_id, course_id, comment, rating, review_date, status) VALUES (2, 2, 2, 'Comment B', 4, CURRENT_DATE, 'pending');
INSERT INTO Review (user_id, professor_id, course_id, comment, rating, review_date, status) VALUES (3, 3, 3, 'Comment C', 3, CURRENT_DATE, 'rejected');

-- Insertando review comments
INSERT INTO ReviewComment (review_id, user_id, text, comment_date) VALUES (1, 1, 'Review Comment A', CURRENT_DATE);
INSERT INTO ReviewComment (review_id, user_id, text, comment_date) VALUES (2, 2, 'Review Comment B', CURRENT_DATE);
INSERT INTO ReviewComment (review_id, user_id, text, comment_date) VALUES (3, 3, 'Review Comment C', CURRENT_DATE);

-- Insertando tags
INSERT INTO Tag (description) VALUES ('Tag A');
INSERT INTO Tag (description) VALUES ('Tag B');
INSERT INTO Tag (description) VALUES ('Tag C');

-- Insertando moderation actions
INSERT INTO ModerationAction (review_id, admin_id, action_type, action_date, comment) VALUES (1, 3, 'approve', CURRENT_DATE, 'Moderation Comment A');
INSERT INTO ModerationAction (review_id, admin_id, action_type, action_date, comment) VALUES (2, 3, 'reject', CURRENT_DATE, 'Moderation Comment B');
INSERT INTO ModerationAction (review_id, admin_id, action_type, action_date, comment) VALUES (3, 3, 'edit', CURRENT_DATE, 'Moderation Comment C');
