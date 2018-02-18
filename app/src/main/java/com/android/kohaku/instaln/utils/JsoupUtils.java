package com.android.kohaku.instaln.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by monis.q on 04-02-2018.
 */

public class JsoupUtils {

    public static Document getDocument(String urlString) throws IOException {
        return Jsoup.connect(urlString).get();
    }

    public static String getRawHtml(String urlString) throws IOException {
        return getDocument(urlString).toString();
    }

    public static Elements getElements(String urlString, String cssQuery) throws IOException {
        return getElements(getDocument(urlString), cssQuery);
    }

    public static Elements getElements(Document document, String cssQuery) {
        return document.select(cssQuery);
    }

    public static String[] getElementsStringArray(String urlString, String cssQuery) throws IOException {
        return getElementsStringArray(getDocument(urlString), cssQuery);
    }

    public static String[] getElementsLinksStringArray(String urlString, String cssQuery, String attr) throws IOException {
        return getElementsLinksStringArray(getDocument(urlString), cssQuery, attr);
    }

    public static String[] getElementsStringArray(Document document, String cssQuery) {
        return getElementsStringArray(getElements(document, cssQuery));
    }

    public static String[] getElementsLinksStringArray(Document document, String cssQuery, String attr) {
        return getElementsLinksStringArray(getElements(document, cssQuery), attr);
    }

    public static String[] getElementsStringArray(Elements elements) {
        String[] stringArray = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            stringArray[i] = elements.get(i).text().trim();
        }
        return stringArray;
    }

    public static String[] getElementsLinksStringArray(Elements elements, String attr) {
        String[] stringArray = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            stringArray[i] = elements.get(i).absUrl(attr);
        }
        return stringArray;
    }

    public static Element getElement(Document document, String cssQuery) {
        return document.select(cssQuery).first();
    }

    public static String getElementString(Document document, String cssQuery) {
        return getElement(document, cssQuery).text();
    }
}
