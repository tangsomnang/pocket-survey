package com.wadpam.survey.dao;

import com.wadpam.survey.domain.DAnswer;
import java.util.ArrayList;
import java.util.Collection;
import net.sf.mardao.core.Filter;

/**
 * Implementation of Business Methods related to entity DAnswer.
 * This (empty) class is generated by mardao, but edited by developers.
 * It is not overwritten by the generator once it exists.
 *
 * Generated on 2012-10-19T08:40:22.845+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class DAnswerDaoBean 
	extends GeneratedDAnswerDaoImpl
		implements DAnswerDao 
{
    protected GeneratedDResponseDaoImpl myResponseDao;

    @Override
    public Iterable<DAnswer> queryByResponseIds(Collection<Long> ids) {
        final ArrayList keys = new ArrayList();
        for (Long id : ids) {
            keys.add(myResponseDao.getPrimaryKey(null, id));
        }
        final Filter inFilter = createInFilter(COLUMN_NAME_RESPONSE, keys);
        return queryIterable(false, 0, -1, null, null, null, false, null, false, inFilter);
    }

    @Override
    public void setResponseDao(GeneratedDResponseDaoImpl dao) {
        super.setResponseDao(dao);
        this.myResponseDao = dao;
    }
    
}
