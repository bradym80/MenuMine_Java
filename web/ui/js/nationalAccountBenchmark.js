	var sectors = [
		<webwork:iterator value="nationalAccountBenchmarkWebOptions.sectorSegmentChainRelations.incidenceSectors" status="mestatus">
			<webwork:if test="#mestatus.count!=1">
			,
			</webwork:if>
			"<webwork:property value="name"/>"
		</webwork:iterator>
		];	
		
		//[["S1","S2","S3" ],["S4","S5","S6" ],["S7","S8","S9" ]];
		var segmentsBySector =[
	<webwork:iterator value="nationalAccountBenchmarkWebOptions.sectorSegmentChainRelations.incidenceSectors" status="mestatusSector">
				<webwork:if test="#mestatusSector.count!=1">
					,
				</webwork:if>
				[
				<webwork:iterator value="incidenceSegments" status="mestatus">
					<webwork:if test="#mestatus.count!=1">
					,
					</webwork:if>
					"<webwork:property value="name"/>"
				</webwork:iterator>
				]
		</webwork:iterator>
		];	
		
		
		//[
		//[["a","b","c" ],["d","e","f" ],["g","h","i" ]],
		//[["j","k","l" ],["m","n","o" ],["p","q","r" ]],
		//[["s","t","u" ],["v","w","x" ],["y","z","aa" ]]
		//];
		var chainsBySector = [
	<webwork:iterator value="nationalAccountBenchmarkWebOptions.sectorSegmentChainRelations.incidenceSectors" status="mestatusSector">
					<webwork:if test="#mestatusSector.count!=1">
					,
					</webwork:if>
				[
				<webwork:iterator value="incidenceSegments" status="mestatusSegment">
					<webwork:if test="#mestatusSegment.count!=1">
					,
					</webwork:if>
					[
					<webwork:iterator value="incidenceChains" status="mestatus">
						<webwork:if test="#mestatus.count!=1">
						,
						</webwork:if>
						"<webwork:property value="name" />"
					</webwork:iterator>
					]
			</webwork:iterator>
				]
		</webwork:iterator>
		];	
		
		
		function getSegmentSize(chains, segment,sector) {
			//var chains = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetChains'];
			//var sector = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetSectors'];
			//var segment = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetSegments'];
			
			
			var sizeSector = 0;	
	
	
			for(ii = 0;ii <sector.options.length; ++ii )
			{
				if(sector.options[ii].selected){	
					var sectorSegment = segmentsBySector[ii];
					
						for(j=0; j< sectorSegment.length; ++j)
						{
							sizeSector++;	
						}
				}	
		
				
			}
			
			return sizeSector;
		}
				
		
		function getChainSize(chains, segment,sector) {
			//var chains = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetChains'];
			//var sector = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetSectors'];
			//var segment = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetSegments'];
			
			
			var size = 0; 
			var sizeSector = 0;
		for(ii = 0;ii <sector.options.length; ++ii )
		{
			if(sector.options[ii].selected)
			{	
				var sectorSegment = segmentsBySector[ii];
				
				for(j=0; j< sectorSegment.length; ++j)
				{					
					if(segment.options[sizeSector].selected)
					{

						var sectorChains = chainsBySector[ii][j];
						for(jj=0; jj< sectorChains.length; ++jj)
						{
						
							size++;
						}
					}
					sizeSector++;
				}	
			}		
			
			
		
		}
			
			return size;
		}
		
		function updateTarget()
		{
			var chains = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetChains'];
			var sector = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetSectors'];
			var segment = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.targetSegments'];
			update(chains, segment,sector);
		}
		
		function update(chains, segment,sector) {

		var sizeSector = 0;	
		var size =  0;
	
		
		
		
		// Figure out what was selected For segments.
		var selectedSegment = new Array();
		for(ii = 0;ii <segment.options.length; ++ii )
		{
			if(segment.options[ii].selected)
			{
				selectedSegment[selectedSegment.length] = 	segment.options[ii].text;
				
			}
		}
		
		// Figure out what was selected For chains.
		var selectedChains = new Array();
		for(ii = 0;ii <chains.options.length; ++ii )
		{
			if(chains.options[ii].selected)
			{
				selectedChains[selectedChains.length] = chains.options[ii].text;
			}
		}
		
		
		
		segment.length=getSegmentSize(chains, segment,sector);
		chains.length=getChainSize(chains,segment,sector);
		
		for(ii = 0;ii <sector.options.length; ++ii )
		{
			if(sector.options[ii].selected)
			{	
			

				var sectorSegment = segmentsBySector[ii];

				
				for(j=0; j< sectorSegment.length; ++j)
				{
					segment.options[sizeSector].text=segmentsBySector[ii][j];
					segment.options[sizeSector].value=segmentsBySector[ii][j];
					if(segment.options[sizeSector].selected)
					{
						var sectorChains = chainsBySector[ii][j];
						for(jj=0; jj< sectorChains.length; ++jj)
						{
						
							chains.options[size].text=sectorChains[jj];
							chains.options[size++].value=sectorChains[jj];
						}
					}
					sizeSector++;
				}	
			}		
		}


		/*
		* Make sure the same options are selected
		*/
		for(ii = 0;ii <segment.options.length; ++ii )
		{
			segment.options[ii].selected = false;
			for(j = 0;j <selectedSegment.length; ++j )
			{
				if(segment.options[ii].text == selectedSegment[j] )
				{
					segment.options[ii].selected = true;
				}
			}
			
			
		}
		
		
		/*
		* Make sure the same options are selected
		*/
		for(ii = 0;ii <chains.options.length; ++ii )
		{
			chains.options[ii].selected = false;
			for(j = 0;j <selectedChains.length; ++j )
			{
				if(chains.options[ii].text == selectedChains[j] )
				{
					chains.options[ii].selected = true;
				}
			}
			
			
		}
		
}
		

		function updateBenchmark() {
		var chains = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.benchmarkChains'];
		var sector = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.benchmarkSectors'];
		var segment = document.forms['menuMineStatisticalTable'].elements['nationalAccountBenchmarkWebOptions.benchmarkSegments'];
		
		update(chains, segment,sector);
		
			
}