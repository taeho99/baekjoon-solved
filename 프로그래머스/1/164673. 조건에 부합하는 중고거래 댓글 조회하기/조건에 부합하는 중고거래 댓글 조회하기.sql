select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date, '%Y-%m-%d') "created_date"
from used_goods_board b join used_goods_reply r
on b.board_id = r.board_id
where '2022-10-01' <= b.created_date && b.created_date <= '2022-10-31'
order by r.created_date, b.title