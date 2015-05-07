import java.sql.SQLException;
import java.util.List;

import com.sds.icto.dao.EmailListDAO;
import com.sds.icto.vo.EmailListVO;

public class Test {

	public static void main(String[] args) throws SQLException {

		testInsert();
		testFetchList();
	}

	public static void testInsert() {
		EmailListVO vo = new EmailListVO(0, "룰루", "ㄹㄹ", "ㄹㄹ");
		EmailListDAO dao = new EmailListDAO();

		dao.insert(vo);

	}

	public static void testFetchList() throws SQLException {

		EmailListDAO dao = new EmailListDAO();
		List<EmailListVO> list = dao.fetchList();

		for (EmailListVO emailListVO : list) {
			System.out.println(emailListVO);
		}
	}
}
