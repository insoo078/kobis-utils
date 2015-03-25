package org.kobic.kobis.unmapped.dao;

import org.kobic.kobis.main.vo.D1CommonVO;

public interface UnmappedDAO{
    public int insertUnmappedD1Common( D1CommonVO commonSheet );
    public String getAccessionNum( String accession_no, String ins_cd );
}
