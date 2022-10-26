package com.practice.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.practice.core.models.MultifieldHelper;
import com.practice.core.models.NastedHalper;
import com.practice.core.models.Surgeit;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class,adapters = Surgeit.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Surgeitmpl implements Surgeit {
	private static final Logger LOG = LoggerFactory.getLogger(Surgeitmpl.class);

	@Inject
	Resource componentResource; 

    public List<Map<String, String>> getJavatrainerfun() {
		// TODO Auto-generated method stub
		List<Map<String, String>> multiList = new ArrayList<>();

		
	try {
		Resource resource =componentResource.getChild("bookdetailsinsurge");
			//Resource resource = componentResource.getChild("bookdetailsinsurge");
		for (Resource rs : resource.getChildren()) {
			Map<String, String> mmp=new HashMap<>();
	
		        mmp.put("NAME", rs.getValueMap().get("bookname",String.class));
				mmp.put("NUMBER", rs.getValueMap().get("publishyear", String.class));
// all the information store in the rs we adapt the values fro, the cqdailog for that we have to use get vlue map
				multiList.add(mmp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return multiList;

	}

    public List<MultifieldHelper> getBookDetailsWithNastedMultifield() {
        List<MultifieldHelper> bookDetailsNasted=new ArrayList<>();
         try {
            Resource bookDetailNasted=componentResource.getChild("bookdetailswithnastedmultifield");
            if(bookDetailNasted!=null){
                for (Resource bookNasted : bookDetailNasted.getChildren()) {
                	MultifieldHelper multifieldHelper=new MultifieldHelper(bookNasted);
                    if(bookNasted.hasChildren()){
                        List<NastedHalper> bookNastedList=new ArrayList<>();
                        Resource nastedResource=bookNasted.getChild("bookeditons");
                        for(Resource nasted : nastedResource.getChildren()){
                            bookNastedList.add(new NastedHalper(nasted));
                        }
                        multifieldHelper.setBookEditons(bookNastedList);
                    }
                    bookDetailsNasted.add(multifieldHelper);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details With Nasted Multifield {} ",e.getMessage());
        }
        LOG.info("\n SIZE Multifield {} ",bookDetailsNasted.size());
        return bookDetailsNasted;
    }


}
