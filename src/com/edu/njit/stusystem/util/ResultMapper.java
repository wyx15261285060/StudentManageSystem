package com.edu.njit.stusystem.util;

import java.sql.ResultSet;

public interface ResultMapper {
	
	Object mapper(ResultSet rs) throws Exception;

}
