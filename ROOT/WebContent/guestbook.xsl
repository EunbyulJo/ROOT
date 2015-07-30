<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="guestlist">
		<h1>GuestBook</h1>
		<xsl:for-each select="guest">
			<ul>
				<li>
					작성자 :
					<xsl:value-of select="writer" />
				</li>
				<li>
					내용 :
					<xsl:value-of select="content" />
				</li>
				<li>
					날짜 :
					<xsl:value-of select="writedate" />
				</li>
			</ul>
			<hr />
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>