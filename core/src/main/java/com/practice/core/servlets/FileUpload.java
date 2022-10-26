package com.practice.core.servlets;

// import com.adobe.granite.workflow.model.WorkflowModel;
// import com.adobe.xfa.ut.StringUtils;
// import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.dam.api.AssetManager;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.model.WorkflowModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
// import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
// import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
// import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

// import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class })
@SlingServletPaths(value = "/bin/uploadDAMAsset")
@ServiceDescription("Image dam Demo Servlet")
public class FileUpload extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUpload.class);

    @Override
    protected void doPost(final SlingHttpServletRequest request,
            final SlingHttpServletResponse response) throws ServletException, IOException {

        final ResourceResolver resourceResolver = request.getResourceResolver();

        // String fName = request.getParameter("inputFile");
        // LOGGER.info("fileName" + fName);
        String payload = request.getRequestParameter("inputFile").getString();
        LOGGER.info("html data" + payload);
        try {
            if (StringUtils.isNotBlank(payload)) {
                WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);
                WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/fileUpload");
            }
        } catch (Exception e) {
            LOGGER.info("hi", e);
        }
        // Map<String, RequestParameter[]> requestParameterMap =
        // request.getRequestParameterMap();
        // for (Entry<String, RequestParameter[]> paramPair :
        // requestParameterMap.entrySet()) {
        // String key = paramPair.getKey();
        // if (key.equals("inputFile")) {
        // RequestParameter[] values = paramPair.getValue();
        // RequestParameter paramVal = values[0];
        // try {
        // InputStream inputStream = paramVal.getInputStream();
        // String fname = paramVal.getFileName();
        // LOGGER.info("filename is " + fname);
        // String mimType = paramVal.getContentType();
        // LOGGER.info("mimType is " + mimType);
        // ResourceResolver resourceResolver = request.getResourceResolver();
        // if (null != inputStream) {
        // AssetManager assetMgr = resourceResolver.adaptTo(AssetManager.class);
        // assetMgr.createAsset("/content/dam/text/emails/" + fname, inputStream,
        // mimType, true);
        // }
        // LOGGER.info("Assest Created successfully");
        // } catch (IOException e) {
        // LOGGER.error("Error while getting the input stream and creating DAM asset: {}
        // {}", e.getMessage(),
        // e);
        // }
        // }
        // }
    }
}
