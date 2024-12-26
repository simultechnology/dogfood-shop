-- Categories
INSERT INTO categories (name, description) VALUES
('パピー用', '子犬のための栄養バランスの取れたフード'),
('アダルト用', '成犬のための日常的なフード'),
('シニア用', '高齢犬のための消化に優しいフード'),
('グレインフリー', '穀物不使用の特別なフード')
ON CONFLICT DO NOTHING;